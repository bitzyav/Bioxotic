package trinidad.daniel.bioxotic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import trinidad.daniel.bioxotic.entities.Message

public class MessagesAdapter: BaseAdapter {
    var messages = ArrayList<Message>()
    var context: Context? = null

    constructor(context: Context, messages: ArrayList<Message>){
        this.context = context
        this.messages = messages
    }

    override fun getCount(): Int {
        return messages.size
    }

    override fun getItem(p0: Int): Any {
        return messages[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var msg = messages[p0]
        var inflater = LayoutInflater.from(this.context)
        var view = inflater.inflate(R.layout.item_messages, null)

        val username: TextView = view.findViewById(R.id.user_name)
        val messg: TextView = view.findViewById(R.id.user_msg)

        username.setText(msg.email)
        messg.setText(msg.text)

        return view
    }
}