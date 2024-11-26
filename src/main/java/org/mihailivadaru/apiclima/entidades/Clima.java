package org.mihailivadaru.apiclima.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "clima")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Clima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ciudad;
    private String estado;
    private double temperatura;
    private int humedad;
    private LocalDate fecha;

}
