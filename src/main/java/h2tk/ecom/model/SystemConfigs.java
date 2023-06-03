package h2tk.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SystemConfigs")
public class SystemConfigs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "value_string")
    private String valueString;

    @Column(name = "value_int")
    private int valueInt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public SystemConfigs(int id, String code, String valueString, int valueInt) {
        this.id = id;
        this.code = code;
        this.valueString = valueString;
        this.valueInt = valueInt;
    }

    public SystemConfigs() {
    }
}
