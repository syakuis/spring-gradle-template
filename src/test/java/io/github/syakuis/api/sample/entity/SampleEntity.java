package io.github.syakuis.api.sample.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "sample")
public class SampleEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDatetime;

    @Builder
    public SampleEntity(String name) {
        this.name = name;
    }

    public void delete() {
        this.deleted = true;
    }

}
