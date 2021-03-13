package fr.idmc.m2.modeldrivenarchitecture.domainmodelexample;


import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "LINEITEM" ) 
public class LineItem {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_line_item")
    private Integer id;
	
	@Column(name = "quantity", nullable=false)	
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_order")
    private Order order = new Order ();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_stock_item")
    private StockItem item = new StockItem ();
	
	private ShoppingBasket sb = new ShoppingBasket();

}