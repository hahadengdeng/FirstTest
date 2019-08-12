package Service;


import Entity.Provider;
import Instrument.Page;



public interface ProviderService {
    public Page<Provider> findall(Provider[] providers, Page<Provider> page);

    public int count() ;

    public boolean checkRename(String name, int id);

    public boolean addRename(String name) ;

    public boolean add(Provider provider);

    public boolean updatevider(Provider provider);

    public boolean delectvider(String name);

    public int[] insertmore(Object[][] objects);
}
