package ru.otus.xml.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="dataList")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestDataWrapper {

    @XmlElement(name="data")
    private List<TestData> data;
}
