
package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.Employee;
import com.mwr.database.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.classic.Session;

@ManagedBean(name = "val")
@SessionScoped
public class ValidationBean {

        private Boolean exist = null;
        private DatabaseJSFManagedBean d;
        
        public Boolean empExist(String id)
        {
            Employee e = d.getEmployee(id);
            if (e == null)
                exist = false;
            else exist = true;
            return exist;
        }
        public Boolean devExist(int id)
        {
            Device e = d.getDevice();
            if (e == null)
                exist = false;
            else exist = true;
            return exist;
        }

}
