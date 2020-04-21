package com.sf_ecommerce.fncom.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sf_ecommerce.fncom.dto.request.create.products.CollectDTO;
import com.sf_ecommerce.fncom.dto.request.create.products.ImageDTO;
import com.sf_ecommerce.fncom.dto.request.create.products.OptionsDTO;
import com.sf_ecommerce.fncom.dto.request.create.products.VariantDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseDTO implements Serializable {

    private static final long serialVersionUID = -2815344150359540692L;

    private String bodyHtml;

    private String handle;

    private Set<ImageDTO> images;

    private List<OptionsDTO> options;

    private String productType;

    private String publishedScope;

    private List<String> tags;

    private String templateSuffix;

    private String title;

    private Set<VariantDTO> variants;

    private String vendor;

    private CollectDTO collect;

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public Set<ImageDTO> getImages() {
        return images;
    }

    public void setImages(Set<ImageDTO> images) {
        this.images = images;
    }

    public List<OptionsDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsDTO> options) {
        this.options = options;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPublishedScope() {
        return publishedScope;
    }

    public void setPublishedScope(String publishedScope) {
        this.publishedScope = publishedScope;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTemplateSuffix() {
        return templateSuffix;
    }

    public void setTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<VariantDTO> getVariants() {
        return variants;
    }

    public void setVariants(Set<VariantDTO> variants) {
        this.variants = variants;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public CollectDTO getCollect() {
        return collect;
    }

    public void setCollect(CollectDTO collect) {
        this.collect = collect;
    }

    @Override
    public String toString() {
        return "ProductCreateDTO{" +
                "bodyHtml='" + bodyHtml + '\'' +
                ", handle='" + handle + '\'' +
                ", images=" + images +
                ", options=" + options +
                ", productType='" + productType + '\'' +
                ", publishedScope='" + publishedScope + '\'' +
                ", tags='" + tags + '\'' +
                ", templateSuffix='" + templateSuffix + '\'' +
                ", title='" + title + '\'' +
                ", variants=" + variants +
                ", vendor='" + vendor + '\'' +
                ", collect=" + collect +
                '}';
    }

}
