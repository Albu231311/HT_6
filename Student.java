///Nery Molina 23218
public class Student {
    private String name;
    private String phone;
    private String email;
    private String postalZip;
    private String country;

    public Student(String name,String phone,String email,String postalZip,String country) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.postalZip= postalZip;
        this.country = country;
    
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public String getCountry() {
        return country;
    }
    public String getNationality() {
        return country;
    }

    public String toString() {
        return "Name: " + name + ", Numero: "+phone+", Email: "+email+", PostalZip: "+postalZip+ ", Nacionalidad: " + country;
    }
}

