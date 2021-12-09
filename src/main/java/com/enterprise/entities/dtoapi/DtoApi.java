package com.enterprise.entities.dtoapi;

import com.enterprise.entities.apiEntity.Ref;
import com.enterprise.entities.apiEntity.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Set;


public class DtoApi {

    private String nameParameter;

    private String inParameter;

    private String DescriptionParameter;

    private String requireParameter;

    private String typeParameter;

    private Set<String> tagsDescritpion;

    private Set<String> refDescription;

    private String methodDescription;


    private String pathDescription;


    private String operationIdDescritpion;


    private String summaryDescription;


    private String descriptionResume;

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }

    public void setInParameter(String inParameter) {
        this.inParameter = inParameter;
    }

    public void setDescriptionParameter(String descriptionParameter) {
        DescriptionParameter = descriptionParameter;
    }

    public void setRequireParameter(String requireParameter) {
        this.requireParameter = requireParameter;
    }

    public void setTypeParameter(String typeParameter) {
        this.typeParameter = typeParameter;
    }

    public void setTagsDescritpion(Set<String> tagsDescritpion) {
        this.tagsDescritpion = tagsDescritpion;
    }

    public void setRefDescription(Set<String> refDescription) {
        this.refDescription = refDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public void setPathDescription(String pathDescription) {
        this.pathDescription = pathDescription;
    }

    public void setOperationIdDescritpion(String operationIdDescritpion) {
        this.operationIdDescritpion = operationIdDescritpion;
    }

    public void setSummaryDescription(String summaryDescription) {
        this.summaryDescription = summaryDescription;
    }

    public void setDescriptionResume(String descriptionResume) {
        this.descriptionResume = descriptionResume;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    public String getInParameter() {
        return inParameter;
    }

    public String getDescriptionParameter() {
        return DescriptionParameter;
    }

    public String getRequireParameter() {
        return requireParameter;
    }

    public String getTypeParameter() {
        return typeParameter;
    }

    public Set<String> getTagsDescritpion() {
        return tagsDescritpion;
    }

    public Set<String> getRefDescription() {
        return refDescription;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public String getPathDescription() {
        return pathDescription;
    }

    public String getOperationIdDescritpion() {
        return operationIdDescritpion;
    }

    public String getSummaryDescription() {
        return summaryDescription;
    }

    public String getDescriptionResume() {
        return descriptionResume;
    }

    @Override
    public String toString() {
        return "DtoApi{" +
                "nameParameter='" + nameParameter + '\'' +
                ", inParameter='" + inParameter + '\'' +
                ", DescriptionParameter='" + DescriptionParameter + '\'' +
                ", requireParameter='" + requireParameter + '\'' +
                ", typeParameter='" + typeParameter + '\'' +
                ", tagsDescritpion=" + tagsDescritpion +
                ", refDescription=" + refDescription +
                ", methodDescription='" + methodDescription + '\'' +
                ", pathDescription='" + pathDescription + '\'' +
                ", operationIdDescritpion='" + operationIdDescritpion + '\'' +
                ", summaryDescription='" + summaryDescription + '\'' +
                ", descriptionResume='" + descriptionResume + '\'' +
                '}';
    }
}
