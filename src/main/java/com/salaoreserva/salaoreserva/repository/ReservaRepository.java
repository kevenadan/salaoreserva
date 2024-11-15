package com.salaoreserva.salaoreserva.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salaoreserva.salaoreserva.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	@Query("SELECT DISTINCT CAST(r.dataReserva as LocalDate) FROM Reserva r WHERE r.status = 'CONFIRMADA' AND r.salao.tipoSalao = :tipoSalao")
	List<LocalDate> findDiasOcupadosByTipoSalao(@Param("tipoSalao") String tipoSalao);

	@Query("SELECT r FROM Reserva r WHERE DATE(r.dataReserva) = :data")
	List<Reserva> findByDataReserva(LocalDate data);

}
