package com.example.springioc.event;

import java.beans.PropertyEditorSupport;

// PropertyEditor 인터페이스 모두 구현 해도 됨
// PropertyEditorSupport를 상속 받아도 가능
// setvalue, getvalue 스레드에서 공유한다 따라서 thread safe 하지 않음
// propertyeditor는 bean 등록 하면 안됨
public class AnotherEventEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        AnotherEvent  value = (AnotherEvent) getValue();
        return value.getId().toString();
    }
    // text를 클래스로 구현해야 할때 사용
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new AnotherEvent(Integer.parseInt(text)));
    }
}
