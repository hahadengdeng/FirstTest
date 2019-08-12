package view;

import Entity.Admin;
import Instrument.Page;
import Service.managerImpl;

import java.util.List;


public class AdminAction {

    managerImpl magerImpl = new managerImpl();

    public boolean login(Admin admin) {
        boolean result = false;
        if (magerImpl.login(admin)) {
            result = true;
        }
        return result;
    }

    public Page<Admin> findall(Admin[] admins, Page<Admin> page)  {
        return magerImpl.findall(admins, page);
    }

    public boolean checkRename(Admin admin)  {
        return magerImpl.checkRename(admin);
    }


    public boolean resigst(Admin admin) {
        return magerImpl.resigst(admin);
    }

    public List<Admin> getadmin(){return magerImpl.getadmin();}
}
