package dataBase.dbUtils;

import dataBase.beans.CBS_MusteriBean;
import dataBase.beans.EmailCustomersBean;
import dataBase.beans.CBS_Erisim_RolBean;
import lombok.Getter;


public class BeansClasses {

    @Getter
    public  EmailCustomersBean emailCustomersBean = new EmailCustomersBean();
    @Getter
    public CBS_Erisim_RolBean CBSErisimRolBean = new CBS_Erisim_RolBean();
    @Getter
    public CBS_MusteriBean cbs_musteriBean = new CBS_MusteriBean();

}
