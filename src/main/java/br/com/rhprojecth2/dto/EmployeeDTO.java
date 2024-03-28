package br.com.rhprojecth2.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "tb_employees")
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "emp_address")
    private String address;

    @Column(name = "emp_hiringdate")
    private Date hiringDate;

    @ManyToOne
    @JoinColumn(name = "dpt_id")
    private DepartmentDTO department;

}
