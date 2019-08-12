package Entity;

public class Category {
    private int categoryID;
    private String category_name;
    private String category_desc;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }

    public Category() {
    }

    public Category(String category_name, String category_desc) {
        this.category_name = category_name;
        this.category_desc = category_desc;
    }

    public Category(int categoryID, String category_name, String category_desc) {
        this.categoryID = categoryID;
        this.category_name = category_name;
        this.category_desc = category_desc;
    }

    public Category(int categoryID, String category_name) {
        this.categoryID = categoryID;
        this.category_name = category_name;
    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", category_name='" + category_name + '\'' +
                ", category_desc='" + category_desc + '\'' +
                '}';
    }

}
