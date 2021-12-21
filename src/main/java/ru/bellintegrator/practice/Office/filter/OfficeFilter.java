package ru.bellintegrator.practice.Office.filter;

public class OfficeFilter {
    private Long idOrg;
    private String name;
    private Boolean isActive;

    public OfficeFilter(Long idOrg, String name, Boolean isActive) {
        this.idOrg = idOrg;
        this.name = name;
        this.isActive = isActive;
    }

    public Long getIdOrg() {
        return idOrg;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return isActive;
    }


    @Override
    public String toString() {
        return "OfficeFilter{" +
                "idOrg=" + idOrg +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
