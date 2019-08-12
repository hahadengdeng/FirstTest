package Service;

import Entity.Admin;
import Instrument.Page;

import java.util.List;


public interface MangerService {
    public boolean login( Admin admin);

    public Page<Admin> findall(Admin[] admins, Page<Admin> page);

    public int count() ;

    public boolean checkRename(Admin admin);

    public boolean resigst(Admin admin);

    public List<Admin> getadmin();
}
