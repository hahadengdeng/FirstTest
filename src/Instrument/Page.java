package Instrument;


import java.util.List;

public class Page<T> {
    private int pageSize;
    private int localPage;

    private int count;
    private List<T> list;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getLocalPage() {
        return localPage;
    }

    public void setLocalPage(int localPage) {
        this.localPage = localPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int upPage() {
        if (localPage > 1) {
            return this.localPage - 1;
        }
        return 1;

    }

    public int nextPage() {
        if (localPage < countPage()) {
            return this.localPage + 1;
        }
        return countPage();
    }

    public int countPage() {
        return (count + pageSize - 1) / pageSize;
    }

    public Page() {
    }

    public Page(int pageSize, int localPage) {
        this.pageSize = pageSize;
        this.localPage = localPage;
    }
}
