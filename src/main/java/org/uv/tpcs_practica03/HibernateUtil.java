/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcs_practica03;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author anton
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/practica03");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "");
            //Se ocupa en debuggers. 29 Log histirico, 30 subproceso o hilo de control
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//            settings.put(Environment.HBM2DDL_AUTO, "update");
            configuration.setProperties(settings);
            
            
            configuration.addAnnotatedClass(Cliente.class);
            configuration.addAnnotatedClass(Producto.class);
            configuration.addAnnotatedClass(Venta.class);
            configuration.addAnnotatedClass(DetVenta.class);
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
        }
        return sessionFactory;
    }
    
}
