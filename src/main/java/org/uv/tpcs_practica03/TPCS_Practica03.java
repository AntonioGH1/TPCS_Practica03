/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tpcs_practica03;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author anton
 */
public class TPCS_Practica03 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        
//        Cliente emp = new Cliente();
//        emp.setNombre("Ana");
//        emp.setRFC("qwerty2");
        
//        Venta ve = new Venta();
//        ve.setCliente(1);
//        ve.setFecha("2022-01-01");
//        ve.setTotal(100.00f);
        
//        Producto pro = new Producto();
//        pro.setDescripcion("Recarga $50");
//        pro.setPrecio(51.00);
//        pro.setExistencia(999);
//        pro.setCosto(50.00);
        
        

        
        
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();
        
        String hql = "FROM producto";
        Query query = session.createQuery(hql);
        List<Producto> resultados = query.list();
        
        List<String> listaDeCadenas = new ArrayList<>();

        for (Producto entidad : resultados) {
            String cadena = "ID: " + entidad.getId() + ", Nombre: " + entidad.getDescripcion();
            listaDeCadenas.add(cadena);
        }

        for (String cadena : listaDeCadenas) {
            System.out.println(cadena);
        }
        
//        session.save(List<Producto>);
//        
//        t.commit();
        session.close();
    }
}
