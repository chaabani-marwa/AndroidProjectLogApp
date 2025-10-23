package com.isetr.logapp

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.isetr.logapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Initialisation et définition du contenu de l'activité
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Récupération de l'objet User passé via l'Intent
        // Note: Pour les API 33 et plus, utilisez getParcelableExtra("EXTRA_USER", User::class.java)
        //val user: User? = intent.getParcelableExtra<User>("EXTRA_USER")
        val user= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EXTRA_USER", User::class.java)
        } else {
            intent.getParcelableExtra<User>("EXTRA_USER")
        }
        if (user != null) {
            // Accès direct aux TextViews via l'objet binding
            binding.textViewEmailLabel.text = "Bienvenue, M . "
            binding.textViewEmailValue.text =  user.username+"@isetr.tn" // "${user.email}@isetr.tn"

            // binding.textViewPassword.text = "Votre mot de passe est : ${user.password}"
        }

        // Gestion de l'Intent implicite
        binding.buttonFacebook.setOnClickListener {
            val facebookIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
            if (facebookIntent.resolveActivity(packageManager) != null) {
                startActivity(facebookIntent)
            } else {
                // AFFICHEZ un message pour confirmer que l'Intent n'a pas été résolu
                Toast.makeText(this, "Erreur : Aucun navigateur web trouvé sur l'appareil.", Toast.LENGTH_LONG).show()
            }
           /* // Crée un Intent pour l'action "VIEW" (visualiser)
            val intent = Intent(Intent.ACTION_VIEW)
            // Définit les données comme l'URI d'un site web
            intent.data = Uri.parse("https://www.google.com")
            // Vérifie qu'il existe bien une application capable de gérer cet Intent
            if (intent.resolveActivity(packageManager) != null) {
                // Lance l'activité qui peut gérer l'affichage de l'URI
                startActivity(intent)
            }*/

        }
        binding.buttonSendMail.setOnClickListener {
            sendEmail()
        }
        binding.buttonLogout.setOnClickListener {

            showLogoutConfirmationDialog()
        //val intent = Intent(this, LoginActivity::class.java)
            //startActivity(intent)
        }
    }

    private fun sendEmail() {
        val desti = "directeur@isetr.tn"
        val subject = "Informations de mon compte (ADMIN)"
        val body = "Bonjour Mr Le directeur ,\n\nMon email de connexion est Admin@isetr.tn ."
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(desti))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        if (emailIntent.resolveActivity(packageManager) != null) {
            val chooserTitle = "Choisir une application de messagerie"
            startActivity(Intent.createChooser(emailIntent, chooserTitle))
        } else {
            Toast.makeText(this, "Aucun client mail n'est installé sur cet appareil.", Toast.LENGTH_LONG).show()
        }
    }
    private fun showLogoutConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Confirmation de déconnexion")
            .setMessage("Êtes-vous sûr de vouloir vous déconnecter et quitter votre session ?")
            // Bouton OUI (Action Positive)
            .setPositiveButton("Oui") { dialog, which ->
                performLogout() // Exécute l'action de déconnexion seulement après confirmation
            }
            // Bouton NON (Action Négative/Annuler)
            .setNegativeButton("Non") { dialog, which ->
                dialog.dismiss() // Ferme simplement la boîte de dialogue
            }
            .setIcon(R.drawable.baseline_app_blocking_24) // Assurez-vous d'avoir une icône de déconnexion pour l'alerte
            .show()
    }

    private fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java).apply {
            // Ces drapeaux effacent toutes les activités de la pile
            // (y compris ProfileActivity) et démarrent LoginActivity comme la seule.
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
    }
}








/*override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_profile)

}*/
