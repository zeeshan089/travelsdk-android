/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Source code is free to use, copy and modify without limitations.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.travelfed.travelsdk.example.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.travelfed.travelsdk.bean.excursion.Excursion;
import com.travelfed.travelsdk.example.R;

/**
 * 
 * @author krumstoilov
 *
 */
public class ExcursionAdapter extends ArrayAdapter<Excursion> {

	private AdapterView.OnItemClickListener onItemClickListener;
	
	public ExcursionAdapter(Context context, List<Excursion> objects, AdapterView.OnItemClickListener onItemClickListener) {
		super(context, R.layout.list_item_excursion, objects);
		this.onItemClickListener = onItemClickListener;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) 
        {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_item_excursion, null, true);
        } 
        
        Excursion excursion = getItem(position);
        
        // Name
        TextView textViewName = (TextView) rowView.findViewById(R.id.excursionItemName);
        textViewName.setText(excursion.getName());
        
        // Info
		StringBuffer stringBuffer = new StringBuffer("City: ");
		stringBuffer.append(excursion.getCity());
		stringBuffer.append(", Duration: ").append(excursion.getDuration());
		((TextView) rowView.findViewById(R.id.excursionItemInfo)).setText(stringBuffer.toString());
		
        // Description
        TextView textViewDescription = (TextView) rowView.findViewById(R.id.excursionItemDescription);
        textViewDescription.setText(excursion.getDescription());
		
        //  Total
        Button buttonGo = (Button) rowView.findViewById(R.id.excursionItemButtonTotal);
        buttonGo.setText(excursion.getCur() + " " + excursion.getTotalPrice() + " > ");
        buttonGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onItemClickListener.onItemClick(null, v, position, 0);
			}
		});

        return rowView;
	}

}
