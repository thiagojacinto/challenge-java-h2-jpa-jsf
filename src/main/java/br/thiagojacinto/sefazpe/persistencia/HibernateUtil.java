package br.thiagojacinto.sefazpe.persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	/*
	 * 		Utilidade para criar sessão no Hibernate.
	 */
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			
			try {
				
				// Instancia o registro:
				registry = new StandardServiceRegistryBuilder().configure().build();
				// cria metadataSources:
				MetadataSources metadataSources = new MetadataSources(registry);
				// a partir dela, cria a metadata:
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				
				// por fim, instancia a SessionFactory com a metadata:
				sessionFactory = metadata.getSessionFactoryBuilder().build();
				
			} catch (Exception e) {
				e.printStackTrace();	// Mostra o trace do error
				
				// Método personalizado `shutdown()`
				shutdown();
				
			}
		}
		
		// Retorna a sessão após configuração:
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (registry != null) {
			// Remove o service no caso do registro ser nulo:
			StandardServiceRegistryBuilder.destroy(registry);
		}
    }
}
