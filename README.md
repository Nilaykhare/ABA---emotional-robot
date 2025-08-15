# Evaluating Patient Trust and Acceptance of Furhat in Emergency Room Setting

This project explores the use of social robots, specifically Furhat, in emergency room scenarios to assess patient trust and acceptance. It focuses on understanding how different robot designs and interaction scripts influence patient perception, trust, and willingness to use social robots in healthcare settings.

## Introduction
- **Goal:** Evaluate whether patients trust and accept social robots in an emergency room setting.  
- **Use Case:** Furhat social robot interacting with patients during emergency situations.  
- **Objective:** Identify factors affecting trust and quantify patient acceptance of social robots.

## Objectives
1. Conduct literature review on social robots and trust.  
2. Design conversational scripts for Furhat interactions.  
3. Develop and administer questionnaires for evaluation.  
4. Perform statistical analysis (descriptive, correlation, regression) to test hypotheses.  
5. Derive insights on factors influencing trust and acceptance.

## Factors Affecting Trust
| Construct | Factors | Relation to Trust |
|-----------|--------|----------------|
| PU (Perceived Usefulness) | Errors in context | Increase in errors decreases trust |
| ATT (Attitude) | Cognitive/Affective attitudes | Emotional appeal on affective attitudes increases trust; cognitive attitudes may decrease trust |
| Trust | Privacy disclosure | Higher privacy disclosure increases trust |
| PS (Perceived Sociability) | Social skills, Anthropomorphism, Apology | Increases trust |
| ITU (Intention to Use) | Interest in using Social Robot | Higher interest increases trust |
| PAD | Decision-making power, Autonomy, Cooperativeness | Higher autonomy increases trust |
| PEOU (Perceived Ease of Use) | Comfort, familiarity with technology | Increases trust |
| ANX (Anxiety) | Psychophysical reactions | Decrease in reactions increases trust |
| FC (Facilitating Conditions) | Social Navigation | Increases trust |

## Experiment Design
- **Scenario:** Patient falls and injures hand; Furhat collects basic information and supports patient socially.  
- **Robot Capabilities:**  
  1. Cannot provide health status or prescribe medications.  
  2. Cannot assist physically.  
  3. Can interact socially and inform medical staff.  
- **Methodology:**  
  1. Two versions of scripted conversation designed for the same scenario.  
  2. Participants interact with both Furhat versions using the provided scripts.  
  3. Questionnaires are filled after each interaction to assess trust, acceptance, and experience.

## Dataset
- **Participants:** 30 individuals (13 female, 17 male)  
- **Age Range:** 21–32  
- **Data Collected:** Responses to trust, acceptance, and interaction-related questionnaires

## Key Findings
1. **Acceptance:** 70% interest for Robotic Furhat vs 80% for Humanoid Furhat, indicating higher acceptance for the humanoid version.  
2. **Perceived Sociability:** Largest difference between Robotic and Humanoid Furhat.  
3. **Regression Analysis:** Higher R² values for Humanoid Furhat, indicating stronger predictive power of trust factors.  
4. **Influencing Factors:**  
   - PU least influences ITU for Humanoid Furhat.  
   - PU most influences ITU for Robotic Furhat.

## Conclusion
- Humanoid Furhat is generally more accepted by patients in an emergency room scenario.  
- Social skills and perceived sociability are critical factors in building trust.  
- Robot design and conversation script significantly affect patient trust and willingness to use.

## Tools & Technologies
- Furhat SDK for conversation design and robot interaction.  
- Python for statistical analysis (descriptive statistics, correlation, regression).  
- Questionnaire-based evaluation for human-robot interaction insights.
