use RFIDSystemDB;
// DELIMITER //
drop procedure if exists RFIDSystemDB.getLocations//
create procedure getLocations(
    id int
    )
BEGIN
	set @groupID = (select GRUPO_IDGRUPO from VISITANTES where TAG_VISITANTE = id);
	select a.NOMBRE, v.NOMBRE from (VISITANTES as v join AREAS as a on a.IDAREA = v.AREA_IDAREA) where v.GRUPO_IDGRUPO = @groupID;
    -- select @groupID;
END;
// DELIMITER ;
