package com.example.mugs_assignment.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mugs_assignment.Login
import com.example.mugs_assignment.MainActivity
import com.example.mugs_assignment.R
import com.google.firebase.auth.FirebaseAuth

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [register_page.newInstance] factory method to
 * create an instance of this fragment.
 */
class register_page : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register_page, container, false)

        view.findViewById<Button>(R.id.to_register).setOnClickListener {
            val act = activity as Login
            act.change(login_page())
        }


        view.findViewById<Button>(R.id.register_btn).setOnClickListener {

            val email = view.findViewById<EditText>(R.id.email_et).text.toString()
            val pass = view.findViewById<EditText>(R.id.password_et).text.toString()

            val auth = FirebaseAuth.getInstance()

            auth.createUserWithEmailAndPassword(
                email,
                pass
            ).addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(context, "Registered Successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment register_page.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            register_page().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}