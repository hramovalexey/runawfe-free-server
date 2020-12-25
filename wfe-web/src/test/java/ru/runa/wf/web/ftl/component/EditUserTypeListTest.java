package ru.runa.wf.web.ftl.component;

import org.junit.jupiter.api.*;
import junit.framework.Assert;

public class EditUserTypeListTest {
    private String testString;
    private String testEmptyString;
    private EditUserTypeList editUserTypeList;

    @BeforeEach
    public void setUp() {
        this.testString = "\"12\n34[[]";
        this.testEmptyString = "";
        this.editUserTypeList = new EditUserTypeList();
    }

    private String oldMethod(String str) {
        return str.replaceAll("\"", "'").replaceAll("\n", "").replace("[]", "{}");
    }

    @Test
    public void inputComponentConverter() {
        String expected = oldMethod(testString);
        String actual = editUserTypeList.inputComponentConverter(testString);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inputComponentConverterNotNull() {
        String expected = editUserTypeList.inputComponentConverter(testEmptyString);
        Assert.assertNotNull(expected);
    }

}