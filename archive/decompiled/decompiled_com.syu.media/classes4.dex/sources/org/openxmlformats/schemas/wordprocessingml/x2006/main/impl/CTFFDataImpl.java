package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFDDList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFHelpText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFStatusText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFTextInput;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMacroName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class CTFFDataImpl extends XmlComplexContentImpl implements CTFFData {
    private static final QName NAME$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
    private static final QName ENABLED$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "enabled");
    private static final QName CALCONEXIT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "calcOnExit");
    private static final QName ENTRYMACRO$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "entryMacro");
    private static final QName EXITMACRO$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "exitMacro");
    private static final QName HELPTEXT$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "helpText");
    private static final QName STATUSTEXT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "statusText");
    private static final QName CHECKBOX$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "checkBox");
    private static final QName DDLIST$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ddList");
    private static final QName TEXTINPUT$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textInput");

    public CTFFDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewCalcOnExit() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(CALCONEXIT$4);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox addNewCheckBox() {
        CTFFCheckBox cTFFCheckBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBoxAdd_element_user = get_store().add_element_user(CHECKBOX$14);
        }
        return cTFFCheckBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList addNewDdList() {
        CTFFDDList cTFFDDListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListAdd_element_user = get_store().add_element_user(DDLIST$16);
        }
        return cTFFDDListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewEnabled() {
        CTOnOff cTOnOffAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffAdd_element_user = get_store().add_element_user(ENABLED$2);
        }
        return cTOnOffAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewEntryMacro() {
        CTMacroName cTMacroNameAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameAdd_element_user = get_store().add_element_user(ENTRYMACRO$6);
        }
        return cTMacroNameAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewExitMacro() {
        CTMacroName cTMacroNameAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameAdd_element_user = get_store().add_element_user(EXITMACRO$8);
        }
        return cTMacroNameAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText addNewHelpText() {
        CTFFHelpText cTFFHelpTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextAdd_element_user = get_store().add_element_user(HELPTEXT$10);
        }
        return cTFFHelpTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName addNewName() {
        CTFFName cTFFNameAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFNameAdd_element_user = get_store().add_element_user(NAME$0);
        }
        return cTFFNameAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText addNewStatusText() {
        CTFFStatusText cTFFStatusTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextAdd_element_user = get_store().add_element_user(STATUSTEXT$12);
        }
        return cTFFStatusTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput addNewTextInput() {
        CTFFTextInput cTFFTextInputAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInputAdd_element_user = get_store().add_element_user(TEXTINPUT$18);
        }
        return cTFFTextInputAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getCalcOnExitArray(int i) {
        CTOnOff cTOnOffFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffFind_element_user = get_store().find_element_user(CALCONEXIT$4, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOffFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getCalcOnExitArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CALCONEXIT$4, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getCalcOnExitList() {
        1CalcOnExitList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CalcOnExitList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox getCheckBoxArray(int i) {
        CTFFCheckBox cTFFCheckBoxFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBoxFind_element_user = get_store().find_element_user(CHECKBOX$14, i);
            if (cTFFCheckBoxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFCheckBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox[] getCheckBoxArray() {
        CTFFCheckBox[] cTFFCheckBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CHECKBOX$14, arrayList);
            cTFFCheckBoxArr = new CTFFCheckBox[arrayList.size()];
            arrayList.toArray(cTFFCheckBoxArr);
        }
        return cTFFCheckBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFCheckBox> getCheckBoxList() {
        AbstractList<CTFFCheckBox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFFCheckBox>() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFFDataImpl.1CheckBoxList
                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFFCheckBox cTFFCheckBox) {
                    CTFFDataImpl.this.insertNewCheckBox(i).set(cTFFCheckBox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFFCheckBox get(int i) {
                    return CTFFDataImpl.this.getCheckBoxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFFCheckBox remove(int i) {
                    CTFFCheckBox checkBoxArray = CTFFDataImpl.this.getCheckBoxArray(i);
                    CTFFDataImpl.this.removeCheckBox(i);
                    return checkBoxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFFCheckBox set(int i, CTFFCheckBox cTFFCheckBox) {
                    CTFFCheckBox checkBoxArray = CTFFDataImpl.this.getCheckBoxArray(i);
                    CTFFDataImpl.this.setCheckBoxArray(i, cTFFCheckBox);
                    return checkBoxArray;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTFFDataImpl.this.sizeOfCheckBoxArray();
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList getDdListArray(int i) {
        CTFFDDList cTFFDDListFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListFind_element_user = get_store().find_element_user(DDLIST$16, i);
            if (cTFFDDListFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFDDListFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList[] getDdListArray() {
        CTFFDDList[] cTFFDDListArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DDLIST$16, arrayList);
            cTFFDDListArr = new CTFFDDList[arrayList.size()];
            arrayList.toArray(cTFFDDListArr);
        }
        return cTFFDDListArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFDDList> getDdListList() {
        1DdListList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1DdListList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getEnabledArray(int i) {
        CTOnOff cTOnOffFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffFind_element_user = get_store().find_element_user(ENABLED$2, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOffFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getEnabledArray() {
        CTOnOff[] cTOnOffArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENABLED$2, arrayList);
            cTOnOffArr = new CTOnOff[arrayList.size()];
            arrayList.toArray(cTOnOffArr);
        }
        return cTOnOffArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getEnabledList() {
        1EnabledList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EnabledList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getEntryMacroArray(int i) {
        CTMacroName cTMacroNameFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameFind_element_user = get_store().find_element_user(ENTRYMACRO$6, i);
            if (cTMacroNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMacroNameFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getEntryMacroArray() {
        CTMacroName[] cTMacroNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ENTRYMACRO$6, arrayList);
            cTMacroNameArr = new CTMacroName[arrayList.size()];
            arrayList.toArray(cTMacroNameArr);
        }
        return cTMacroNameArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getEntryMacroList() {
        1EntryMacroList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1EntryMacroList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getExitMacroArray(int i) {
        CTMacroName cTMacroNameFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameFind_element_user = get_store().find_element_user(EXITMACRO$8, i);
            if (cTMacroNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMacroNameFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getExitMacroArray() {
        CTMacroName[] cTMacroNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXITMACRO$8, arrayList);
            cTMacroNameArr = new CTMacroName[arrayList.size()];
            arrayList.toArray(cTMacroNameArr);
        }
        return cTMacroNameArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getExitMacroList() {
        1ExitMacroList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1ExitMacroList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText getHelpTextArray(int i) {
        CTFFHelpText cTFFHelpTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextFind_element_user = get_store().find_element_user(HELPTEXT$10, i);
            if (cTFFHelpTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFHelpTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText[] getHelpTextArray() {
        CTFFHelpText[] cTFFHelpTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(HELPTEXT$10, arrayList);
            cTFFHelpTextArr = new CTFFHelpText[arrayList.size()];
            arrayList.toArray(cTFFHelpTextArr);
        }
        return cTFFHelpTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFHelpText> getHelpTextList() {
        1HelpTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1HelpTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName getNameArray(int i) {
        CTFFName cTFFNameFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFNameFind_element_user = get_store().find_element_user(NAME$0, i);
            if (cTFFNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFNameFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName[] getNameArray() {
        CTFFName[] cTFFNameArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NAME$0, arrayList);
            cTFFNameArr = new CTFFName[arrayList.size()];
            arrayList.toArray(cTFFNameArr);
        }
        return cTFFNameArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFName> getNameList() {
        1NameList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NameList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText getStatusTextArray(int i) {
        CTFFStatusText cTFFStatusTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextFind_element_user = get_store().find_element_user(STATUSTEXT$12, i);
            if (cTFFStatusTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFStatusTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText[] getStatusTextArray() {
        CTFFStatusText[] cTFFStatusTextArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(STATUSTEXT$12, arrayList);
            cTFFStatusTextArr = new CTFFStatusText[arrayList.size()];
            arrayList.toArray(cTFFStatusTextArr);
        }
        return cTFFStatusTextArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFStatusText> getStatusTextList() {
        1StatusTextList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1StatusTextList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput getTextInputArray(int i) {
        CTFFTextInput cTFFTextInputFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInputFind_element_user = get_store().find_element_user(TEXTINPUT$18, i);
            if (cTFFTextInputFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFTextInputFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput[] getTextInputArray() {
        CTFFTextInput[] cTFFTextInputArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TEXTINPUT$18, arrayList);
            cTFFTextInputArr = new CTFFTextInput[arrayList.size()];
            arrayList.toArray(cTFFTextInputArr);
        }
        return cTFFTextInputArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFTextInput> getTextInputList() {
        1TextInputList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TextInputList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewCalcOnExit(int i) {
        CTOnOff cTOnOffInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffInsert_element_user = get_store().insert_element_user(CALCONEXIT$4, i);
        }
        return cTOnOffInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox insertNewCheckBox(int i) {
        CTFFCheckBox cTFFCheckBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBoxInsert_element_user = get_store().insert_element_user(CHECKBOX$14, i);
        }
        return cTFFCheckBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList insertNewDdList(int i) {
        CTFFDDList cTFFDDListInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListInsert_element_user = get_store().insert_element_user(DDLIST$16, i);
        }
        return cTFFDDListInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewEnabled(int i) {
        CTOnOff cTOnOffInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOffInsert_element_user = get_store().insert_element_user(ENABLED$2, i);
        }
        return cTOnOffInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewEntryMacro(int i) {
        CTMacroName cTMacroNameInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameInsert_element_user = get_store().insert_element_user(ENTRYMACRO$6, i);
        }
        return cTMacroNameInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewExitMacro(int i) {
        CTMacroName cTMacroNameInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameInsert_element_user = get_store().insert_element_user(EXITMACRO$8, i);
        }
        return cTMacroNameInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText insertNewHelpText(int i) {
        CTFFHelpText cTFFHelpTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextInsert_element_user = get_store().insert_element_user(HELPTEXT$10, i);
        }
        return cTFFHelpTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName insertNewName(int i) {
        CTFFName cTFFNameInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFNameInsert_element_user = get_store().insert_element_user(NAME$0, i);
        }
        return cTFFNameInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText insertNewStatusText(int i) {
        CTFFStatusText cTFFStatusTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextInsert_element_user = get_store().insert_element_user(STATUSTEXT$12, i);
        }
        return cTFFStatusTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput insertNewTextInput(int i) {
        CTFFTextInput cTFFTextInputInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInputInsert_element_user = get_store().insert_element_user(TEXTINPUT$18, i);
        }
        return cTFFTextInputInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCalcOnExit(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CALCONEXIT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCheckBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHECKBOX$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeDdList(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DDLIST$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEnabled(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENABLED$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEntryMacro(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENTRYMACRO$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeExitMacro(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXITMACRO$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeHelpText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HELPTEXT$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeName(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAME$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeStatusText(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STATUSTEXT$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeTextInput(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTINPUT$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(CALCONEXIT$4, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, CALCONEXIT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(int i, CTFFCheckBox cTFFCheckBox) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFCheckBox cTFFCheckBoxFind_element_user = get_store().find_element_user(CHECKBOX$14, i);
            if (cTFFCheckBoxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFFCheckBoxFind_element_user.set(cTFFCheckBox);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFFCheckBoxArr, CHECKBOX$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(int i, CTFFDDList cTFFDDList) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFDDList cTFFDDListFind_element_user = get_store().find_element_user(DDLIST$16, i);
            if (cTFFDDListFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFFDDListFind_element_user.set(cTFFDDList);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(CTFFDDList[] cTFFDDListArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFFDDListArr, DDLIST$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(int i, CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOffFind_element_user = get_store().find_element_user(ENABLED$2, i);
            if (cTOnOffFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTOnOffFind_element_user.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(CTOnOff[] cTOnOffArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOnOffArr, ENABLED$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(int i, CTMacroName cTMacroName) {
        synchronized (monitor()) {
            check_orphaned();
            CTMacroName cTMacroNameFind_element_user = get_store().find_element_user(ENTRYMACRO$6, i);
            if (cTMacroNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMacroNameFind_element_user.set(cTMacroName);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(CTMacroName[] cTMacroNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMacroNameArr, ENTRYMACRO$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(int i, CTMacroName cTMacroName) {
        synchronized (monitor()) {
            check_orphaned();
            CTMacroName cTMacroNameFind_element_user = get_store().find_element_user(EXITMACRO$8, i);
            if (cTMacroNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTMacroNameFind_element_user.set(cTMacroName);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(CTMacroName[] cTMacroNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMacroNameArr, EXITMACRO$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(int i, CTFFHelpText cTFFHelpText) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFHelpText cTFFHelpTextFind_element_user = get_store().find_element_user(HELPTEXT$10, i);
            if (cTFFHelpTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFFHelpTextFind_element_user.set(cTFFHelpText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFFHelpTextArr, HELPTEXT$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(int i, CTFFName cTFFName) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFName cTFFNameFind_element_user = get_store().find_element_user(NAME$0, i);
            if (cTFFNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFFNameFind_element_user.set(cTFFName);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(CTFFName[] cTFFNameArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFFNameArr, NAME$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(int i, CTFFStatusText cTFFStatusText) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFStatusText cTFFStatusTextFind_element_user = get_store().find_element_user(STATUSTEXT$12, i);
            if (cTFFStatusTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFFStatusTextFind_element_user.set(cTFFStatusText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFFStatusTextArr, STATUSTEXT$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(int i, CTFFTextInput cTFFTextInput) {
        synchronized (monitor()) {
            check_orphaned();
            CTFFTextInput cTFFTextInputFind_element_user = get_store().find_element_user(TEXTINPUT$18, i);
            if (cTFFTextInputFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFFTextInputFind_element_user.set(cTFFTextInput);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(CTFFTextInput[] cTFFTextInputArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFFTextInputArr, TEXTINPUT$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCalcOnExitArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CALCONEXIT$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCheckBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CHECKBOX$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfDdListArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DDLIST$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEnabledArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ENABLED$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEntryMacroArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ENTRYMACRO$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfExitMacroArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXITMACRO$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfHelpTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(HELPTEXT$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NAME$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfStatusTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(STATUSTEXT$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfTextInputArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TEXTINPUT$18);
        }
        return iCount_elements;
    }
}
