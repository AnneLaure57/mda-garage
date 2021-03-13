package fr.idmc.m2.modeldrivenarchitecture.domainmodelexample;

import javax.persistence.*;

import lombok.*;

@Entity
@Table( name = "ORDERSTATUS" ) 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_status")
    private int id;
	
	@Column(name = "packed", nullable=false)	
	private int packed;
	
	@Column(name = "dispatched", nullable=false)	
	private int dispatched;
	
	@Column(name = "delivered", nullable=false)	
	private int delivered;
	
	@Column(name = "closed", nullable=false)	
	private int closed;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_line_item")
    private Order status = new Order ();
	
}