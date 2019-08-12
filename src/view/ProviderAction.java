package view;

import Entity.Provider;
import Instrument.Page;
import Service.ProviderImpl;


public class ProviderAction {
    ProviderImpl viderImpl = new ProviderImpl();

    public Page<Provider> findall(Provider[] providers, Page<Provider> page)  {
        return viderImpl.findall(providers, page);
    }

    public boolean checkRename(String name, int id) {
        return viderImpl.checkRename(name, id);
    }

    public boolean addRename(String name)  {
        return viderImpl.addRename(name);
    }

    public boolean addvider(Provider provider) {
        return viderImpl.add(provider);
    }

    public boolean updatevider(Provider provider) {
        return viderImpl.updatevider(provider);
    }

    public boolean delectvider(String name) {
        return viderImpl.delectvider(name);
    }

    public int[] insertmore(Object[][] objects){
        return viderImpl.insertmore(objects);
    }
}
