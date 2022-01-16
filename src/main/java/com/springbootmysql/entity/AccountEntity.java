package com.springbootmysql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springbootmysql.converter.StringtoZoneDateTime;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.convert.Jsr310Converters.StringToDurationConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ACCOUNT")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)

@EntityListeners(AuditingEntityListener.class)
public class AccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Length(min = 6, max = 64)
  @Column(name = "user_name")
  private String userName;

  @Length( max = 64)
  @Column(name = "first_name")
  private String firstName;

  @Length( max = 64)
  @Column(name = "last_name")
  private String lastName;

  @Column(name = "birthday")
  @JsonDeserialize(using = StringtoZoneDateTime.class) // Doesn't exist, So I created a custom ZonedDateDeserializer utility class.
  private ZonedDateTime birthday;

  @Column(name = "created_date")
  @CreationTimestamp
  private ZonedDateTime createdDate;
}
