package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.ProductItemBinding
import br.com.alura.orgs.models.Product

class ProductListAdapter(
    private val context: Context,
    products: List<Product>
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val dataset = products.toMutableList()

    class ViewHolder(binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val name = binding.productItemName
        private val description = binding.productItemDescription
        private val value = binding.productItemValue

        fun bind(product: Product) {
            //val name = itemView.findViewById<TextView>(R.id.product_item_name)
            name.text = product.name
            //val description = itemView.findViewById<TextView>(R.id.product_item_description)
            description.text = product.description
            //val value = itemView.findViewById<TextView>(R.id.product_item_value)
            value.text = product.value.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val inflater = LayoutInflater.from(context)
        //val view = inflater.inflate(R.layout.product_item, parent, false)
        val binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = dataset[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = dataset.size

    fun refresh(products: List<Product>) {
        this.dataset.clear()
        this.dataset.addAll(products)
        notifyDataSetChanged()
    }

}
