package fr.idmc.m2.modeldrivenarchitecture.domainmodelexample;


import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "STOCKITEM" ) 
public class StockItem {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_stock_item")
    private Integer id;
	
	@Column(name = "catalog_number", nullable=false)	
	private String catalogNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_line_item")
    private LineItem item = new LineItem ();
}