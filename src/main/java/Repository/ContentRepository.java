package dev.bijansaudcontentcalender.contentcalender.Repository;

import dev.bijansaudcontentcalender.contentcalender.model.Content;
import dev.bijansaudcontentcalender.contentcalender.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    //query derivation
    // this is an abastract method
    List<Content> findAllByTitleContains(String keyword);

    // Writing queries in the repository this is called query derivation
    @Query("""
    SELECT * FROM Content
    where status = :status"""
    )
    List<Content> listByStatus(@Param("status") Status status);

}
