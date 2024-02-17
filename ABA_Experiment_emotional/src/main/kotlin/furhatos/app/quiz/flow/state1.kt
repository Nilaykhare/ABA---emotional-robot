package furhatos.app.quiz.flow

import furhatos.app.quiz.*
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.PersonName
import furhatos.app.quiz.gestures.TripleBlink
import furhatos.gestures.Gestures
import furhatos.skills.Skill
import furhatos.flow.kotlin.*
import kotlin.time.Duration

var userName = ""
val state1: State = state(parent = Parent) {
    onEntry {


        //furhat.gesture(Gestures.Surprise(duration = 2.0))
        //furhat.gesture(Gestures.Thoughtful(duration = 2.0))
        //furhat.gesture(TripleBlink, priority = 10)
        //furhat.gesture(Gestures.Smile(strength = 1.0, duration = 2.0))
        delay(1000)
        println("hello") // Print statement corrected
        furhat.gesture(TripleBlink, priority = 10)
        furhat.stopGestures(true)
        furhat.ask("Good day, I am Furhat and I am here to assist you today during your time in the emergency room. " +
                "How are you feeling today?")
    }

    onResponse<Decease> {
        goto(state2)
    }
}

val state2: State = state(parent = Parent) {
    onEntry {
        //furhat.gesture(Gestures.Nod)
        delay(1000)
        furhat.gesture(Gestures.Oh(duration = 2.0))
        furhat.say("I’m sorry to hear that.")
        furhat.gesture(Gestures.ExpressSad(duration = 2.0))
         furhat.say(       " It sounds like you’re having a tough time. " +
                "The medical team and I are here to help you to the best of our abilities."
        )
        furhat.say(" The doctor will be here to see you shortly." )
        delay(1000)
        furhat.gesture(Gestures.BigSmile(strength = 1.0, duration = 20.0))
        //furhat.gesture(GesturesLib.ExpressThinking(duration = 10.0))
        // do an API call here and wait for the result
        //furhat.stopGestures()
        furhat.ask(        "I will be requiring your details. " +
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
                " insurance card on the side table to your left for" +
                " us to collect your information, Harry?”  ")
    }

    onResponse<Insurance> {
        goto(state3b)
    }
}

val state3b: State = state(parent = Parent) {
    onEntry {
        furhat.say( "Thank you, Harry")
        delay(1000)
        furhat.gesture(Gestures.Nod)
        furhat.ask ("Your insurance details have been processed." )
    }

    onResponse<Nervous> {
        goto(state4)
    }
}

val state4: State = state(parent = Parent) {
    onEntry {
        furhat.say("It’s completely normal to feel anxious in situations like these, Harry. ")
        furhat.gesture(Gestures.Smile(strength = 1.0, duration = 2.0))
        delay(1000)
        furhat.stopGestures(true)
        furhat.say(  "Remember, you’re in good hands and the doctors and nurses will do everything " +
                "they can to help you feel better. We will also contact your loved ones. " )
        furhat.gesture(Gestures.Smile(strength = 1.0, duration = 2.0))
        delay(1000)
        //furhat.stopGestures()
        furhat.ask("Could you please give us a name and phone number of your emergency contact?")
    }

    onResponse<Contact> {
         goto(state5)
    }
}

val state5: State = state(parent = Parent){
    onEntry {
        furhat.say("Thank you for sharing the details, Harry." )
        delay(1000)
        furhat.ask( " Please let me know your current pain level." +
                " With 10 being the worst pain you can imagine and 1 being no pain at all")
    }

    onResponse<PainLevel> {
        goto(state6)
    }
}

val state6: State = state(parent = Parent){
    onEntry {
        furhat.gesture(Gestures.Oh(duration = 2.0))
        furhat.gesture(Gestures.ExpressSad(duration = 2.0))
        delay(500)
        furhat.say("Got it, Harry. Thank you for letting me know. " )
        furhat.ask("And just to make sure we've got everything covered," +
                " could you tell me if you have any allergies or medical conditions " +
                "that the doctor should know about?")
    }

    onResponse<Allergy> {
        furhat.say("Thank you for confirming, Harry. " )
        furhat.gesture(Gestures.Smile(strength = 1.0, duration = 2.0))
        delay(500)
        furhat.say("The doctor will be with you shortly. " +
                "Please feel free to ask me for assistance. " +
                "Wishing you a speedy recovery! Take Care")
        furhat.gesture(Gestures.BigSmile(strength = 1.0, duration = 2.0))
        furhat.gesture(Gestures.CloseEyes(strength = 1.0,duration=5.0))
    }
}