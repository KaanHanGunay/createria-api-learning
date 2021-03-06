package tr.com.khg.criteria.web.rest;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.khg.criteria.domain.Car;
import tr.com.khg.criteria.domain.CarStatistic;
import tr.com.khg.criteria.domain.Person;
import tr.com.khg.criteria.domain.maps.PersonMultiAttributes;
import tr.com.khg.criteria.service.CriteriaService;
import tr.com.khg.criteria.service.dto.CarDTO;
import tr.com.khg.criteria.service.dto.PersonDTO;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CriteriaResource {

    private final CriteriaService criteriaService;

    public CriteriaResource(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @GetMapping("/criteria/all")
    public List<PersonDTO> getAll() {
        return criteriaService.selectAll();
    }

    @GetMapping("/criteria/one-attribute")
    public List<String> getAttribute() {
        return criteriaService.selectOneAttribute();
    }

    @GetMapping("/criteria/multiple-attributes")
    public List<Object[]> getMultipleAttributes() {
        return criteriaService.selectMultipleAttributes();
    }

    @GetMapping("/criteria/multiple-attributes-other-way")
    public List<Object[]> getMultipleAttributesOtherWay() {
        return criteriaService.selectMultipleAttributesOtherWay();
    }

    @GetMapping("/criteria/multiple-attributes-with-mapper")
    public List<PersonMultiAttributes> selectMultipleAttributesWithMapper() {
        return criteriaService.selectMultipleAttributesWithMapper();
    }

    @GetMapping("/criteria/tuple")
    public String selectTupleCriteriaQueries() {
        return criteriaService.selectTupleCriteriaQueries();
    }

    @GetMapping("/criteria/multiple-roots")
    public String selectMultipleRoots() {
        return criteriaService.selectMultipleRoots();
    }

    @GetMapping("/criteria/join-queries")
    public List<CarDTO> selectWithJoinQueries() {
        return criteriaService.selectWithJoinQueries();
    }

    @GetMapping("/criteria/get-with-params/{name}")
    public List<PersonDTO> selectWithParameters(@PathVariable String name) {
        return criteriaService.selectWithParameters(name);
    }

    @GetMapping("/criteria/using-aggregate")
    public Long selectUsingAggregateFunctions() {
        return criteriaService.selectUsingAggregateFunctions();
    }

    @GetMapping("/criteria/using-aggregate-mapping")
    public CarStatistic selectUsingAggregateFunctionsWithMapping() {
        return criteriaService.selectUsingAggregateFunctionsWithMapping();
    }

    @GetMapping("/criteria/using-aggregate-mapping-and-join")
    public List<Object[]> selectFromAndJoin() {
        return criteriaService.selectFromAndJoin();
    }

    @GetMapping("/criteria/group-by-having")
    public List<Object[]> selectGroupByAndHaving() {
        return criteriaService.selectGroupByAndHaving();
    }

    @GetMapping("/criteria/order-by")
    public List<Object[]> selectOderBy() {
        return criteriaService.selectOderBy();
    }

    @GetMapping("/criteria/test")
    public List<Object[]> getTest() {
        return criteriaService.getRowNumAndData();
    }

    @GetMapping("/criteria/get")
    public List<?> get() {
        return criteriaService.getA();
    }

    @GetMapping("/criteria/page")
    public Page<Car> getPage() {
        return criteriaService.getPage();
    }
}
