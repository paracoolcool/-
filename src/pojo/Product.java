package pojo;

import javax.xml.crypto.Data;

public class Product {
    private int id,category_id,num,status,priority;
    private String item_type,title,sell_point,image,created_user,modified_user;
    private long price;
    private Data created_time,modified_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSell_point() {
        return sell_point;
    }

    public void setSell_point(String sell_point) {
        this.sell_point = sell_point;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public String getModified_user() {
        return modified_user;
    }

    public void setModified_user(String modified_user) {
        this.modified_user = modified_user;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Data getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Data created_time) {
        this.created_time = created_time;
    }

    public Data getModified_time() {
        return modified_time;
    }

    public void setModified_time(Data modified_time) {
        this.modified_time = modified_time;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", num=" + num +
                ", status=" + status +
                ", priority=" + priority +
                ", item_type='" + item_type + '\'' +
                ", title='" + title + '\'' +
                ", sell_point='" + sell_point + '\'' +
                ", image='" + image + '\'' +
                ", created_user='" + created_user + '\'' +
                ", modified_user='" + modified_user + '\'' +
                ", price=" + price +
                ", created_time=" + created_time +
                ", modified_time=" + modified_time +
                '}';
    }
}
