package br.com.rhprojecth2.repository;

import br.com.rhprojecth2.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

    public List<EmployeeDTO> findByNameContaining (String name);

    @Query(nativeQuery = true, value =
            "SELECT e.* FROM tb_employees e INNER JOIN tb_departments d ON d.id = e.dpt_id "
            + "WHERE e.dpt_id = :dptId ORDER BY e.emp_name ASC")
    public List<EmployeeDTO> findByDepartmentId(@Param("dptId") Long dptId);





}
