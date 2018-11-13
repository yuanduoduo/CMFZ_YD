package com.baizhi.entity;

//上师表(guru)1
  //      id name headPic gender(sex/hot)
public class Guru {
    private String id;
    private String name;
    private String sex;
    private String headPic;

    public Guru() {
        super();
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", headPic='" + headPic + '\'' +
                '}';
    }

    public Guru(String id, String name, String sex, String headPic) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.headPic = headPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
}
