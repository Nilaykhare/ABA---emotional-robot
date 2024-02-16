package furhatos.app.quiz.flow

import furhatos.app.quiz.Contact
import furhatos.app.quiz.Decease
import furhatos.app.quiz.Nervous
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.PersonName
import furhatos.app.quiz.PainLevel
import furhatos.app.quiz.Allergy
import furhatos.gestures.Gestures
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

var userName = ""
val state1: State = state(parent = Parent) {
    onEntry {
        println("hello") // Print statement corrected

        //furhat.gesture(TripleBlink, priority = 10)
        furhat.ask("Good day, I am Furhat and I am here to assist you today during your time in the emergency room. " +
                "How are you feeling today?")



    }

    onResponse<Decease> {
        goto(state2)
    }
}

val state2: State = state(parent = Parent) {
    onEntry {
        furhat.say("I’m sorry to hear that. It sounds like you’re having a tough time. " +
                "The medical team and I are here to help you to the best of our abilities."
        )
        furhat.gesture(Gestures.BigSmile(strength = 1.0, duration = 20.0))
        //furhat.gesture(GesturesLib.ExpressThinking(duration = 10.0))
        // do an API call here and wait for the result
        //furhat.stopGestures()
        furhat.ask(" The doctor will be here to see you shortly." + "I will be requiring your details. " +
                "Please note that " +
                "I will maintain the confidentiality and security of your personal information. " +
                "Could you please give me your name? ")

    }

    onResponse<PersonName> {
        userName += it.intent.value
        goto(state3)
    }
}

val state3: State = state(parent = Parent) {
    onEntry {
        furhat.ask( userName + "“Could you please place your" +
                " insurance card on the side table to your left for us to collect your information, Harry?”  ")
    }

    onResponse<Nervous> {
        goto(state4)
    }
}

val state4: State = state(parent = Parent) {
    onEntry {
        furhat.ask("It’s completely normal to feel anxious in situations like these, Harry. " +
                "Remember, you’re in good hands and the doctors and nurses will do everything " +
                "they can to help you feel better. We will also contact your loved ones. " +
                "Could you please give us a name and phone number of your emergency contact?")
    }

    onResponse<Contact> {
         goto(state5)
    }
}

val state5: State = state(parent = Parent){
    onEntry {
        furhat.ask("Thank you for sharing the details, Harry." +
                " Please let me know your current pain level." +
                " With 10 being the worst pain you can imagine and 1 being no pain at all")
    }

    onResponse<PainLevel> {
        goto(state6)
    }
}

val state6: State = state(parent = Parent){
    onEntry {
        furhat.ask("Got it, Harry. Thank you for letting me know. " +
                "And just to make sure we've got everything covered," +
                " could you tell me if you have any allergies or medical conditions " +
                "that the doctor should know about?")
    }

    onResponse<Allergy> {
        furhat.say("Thank you for confirming, Harry. " +
                "The doctor will be with you shortly. " +
                "Please feel free to ask me for assistance. " +
                "Wishing you a speedy recovery!")
    }
}