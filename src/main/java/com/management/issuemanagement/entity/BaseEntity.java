package com.management.issuemanagement.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created_date")
        private Date createdDate;

        @Column(name = "created_by")
        private String createdBy;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "updated_date")
        private Date updatedDate;

        @Column(name = "updated_by")
        private String updatedBy;

        @Column(name = "is_active")
        private Boolean isActive;

}

