package com.sf_ecommerce.fncom.dto.request.create.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sf_ecommerce.fncom.entities.products.CollectEntity;
import com.sf_ecommerce.fncom.entities.products.ImageEntity;
import com.sf_ecommerce.fncom.entities.products.VariantEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Validated
public class ProductCreateDTO implements Serializable {

    private static final long serialVersionUID = -4880709877939426339L;

    @NotBlank(message = "bodyHtml can not be empty")
    @JsonProperty("body_html")
    private String bodyHtml;

    private String handle;

    private Set<ImageDTO> images;

    private List<OptionsDTO> options;

    @NotBlank(message = "productType can not be empty")
    @JsonProperty("product_type")
    private String productType;

    private String publishedScope;

    @NotNull(message = "tags can not be empty")
    private List<String> tags;

    private String templateSuffix;

    @NotBlank(message = "title can not be empty")
    private String title;

    private Set<VariantDTO> variants;

    @NotBlank(message = "vendor can not be empty")
    private String vendor;

    @Valid
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
