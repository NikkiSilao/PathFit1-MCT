package com.example.pathfit1mct;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class LessonDetailFragment extends Fragment {

    private TextView lessonDetailTitle;
    private TextView lessonContent;
    private TextView pageNumber;
    private Button prevButton;
    private Button nextButton;
    private Button finishButton;

    private int currentLesson = 0; // Initialize with the first lesson
    private int currentPage = 1;
    private static final int totalPagesPerLesson = 12; // Total number of pages per lesson

    private static final String[] lessonTitles = {
            "Introduction of Movement Education", "Components of Physical Fitness",
            "Principles of Physical Training and FITT Principle", "Human Body responsible for the body’s function",
            "Lifespan Development", "Body Posture", "Non locomotor and locomotor",
            "Introduction to Nutrition and Wellness", "Eating Disorder", "Dietary Plan"
    };

    private static final String[][] lessonContents = {
            {
                    "<h2>Introduction of Movement Education</h2>" +
                            "<p><b>Definition of Movement Education</b><br>" +
                            "A strand of teaching or education aims to educate individuals to develop their motor skills, coordination, physical fitness, and understanding of movement principles through activities that promote creativity and lifelong engagement through physical movement and it aims to help individuals improve their motor skills.</p>" +
                            "<p><b>MOTOR SKILLS</b><br>" +
                            "GROSS MOTOR SKILLS: They used the large muscles in the body<br>" +
                            "FINE MOTOR SKILLS: They used the small muscles in the body</p>",

                    "<h2>History of Movement Education</h2>" +
                            "<p>Movement Education in the 1800s to early 1900s. The early pioneers of movement education were influenced by the idea of the body being an expression of movement.</p>" +
                            "<p>Three of the most historically influential individuals: Francois Delsarte, Liselott Diem, Rudolf Von Laban</p>",

                    "<h2>Francois Delsarte</h2>" +
                            "<p>A Frenchman who developed what he termed applied aesthetics and focused his work in the arts contributed critical ideas of connections among the mind, body, and spirit. He also saw the movement as a union of time, space, and motion, believing that expressive movement should relate to the emotion that inspired that movement. He introduced the idea of parallelism in movement the simultaneous motion of two body parts in the same direction and succession and the 9 Laws of Motion: Altitude, Force, Motion, Sequence, Direction, Form, Velocity, Reaction, and Extension.</p>" +
                            //"<img src='file:///android_res/drawable/francois_delsarte.jpg' alt='Francois Delsarte' />",

                            "<h2>Liselott Diem</h2>" +
                            "<p>Liselott Diem, along with her husband, founded an internationally known college in Germany, Deutsche Sporthochschule Köln, to train teachers in sport and physical education. The college taught a natural approach to teaching children to move effectively in all kinds of situations, where the teacher's role was to provide an environment that would encourage children to freely explore movement in their way. Teachers used equipment such as balls, ropes, benches, wands, and boxes to allow children to develop a wide variety of movement responses individually, with partners, or within small groups. Teachers were encouraged to challenge children by asking questions such as 'Who can do this?' and 'How can this be done differently?'</p>" +
                            //"<img src='file:///android_res/drawable/liselott_diem.jpg' alt='Liselott Diem' />",

                            "<h2>Rudolf Von Laban</h2>" +
                            "<p>Rudolf Von Laban is considered by most as the true pioneer of movement education. His critical contribution was the Theory of Movement, focusing specifically on the concept of effort. He believed that the body was an instrument of expression and made a distinction between expressive movement and functional movement. Expressive movement communicates ideas in dance or other forms of artistic expression, while functional movement serves a purpose in everyday life, such as in sports and games. Laban identified four factors of movement: weight, space, time, and flow, which became the bedrock of movement education.</p>" +
                            //"<img src='file:///android_res/drawable/rudolf_von_laban.jpg' alt='Rudolf Von Laban' />",

                            "<h2>Importance of Movement Education</h2>" +
                            "<p>Movement education improves children's body awareness, spatial awareness, motor skills, physical fitness, and ability to work with others. It supports the development of active lifestyles and benefits learning in areas like dance, gymnastics, and sports.</p>",

                    "<h2>Concepts and Elements of Movement Education</h2>" +
                            "<p><b>Body</b></p>" +
                            "<p><b>Space</b></p>" +
                            "<p><b>Effort</b></p>" +
                            "<p><b>Relationship</b></p>",

                    "<h2>Body</h2>" +
                            "<p>Humans need something to move. When the students explore the body as a concept within the movement education framework they understand the body as an instrument that can move either as a whole or in parts.</p>" +
                            "<p><b>Body Parts</b></p>" +
                            "<ul>" +
                            "<li>Hair</li>" +
                            "<li>Head</li>" +
                            "<li>Eye</li>" +
                            "<li>Ear</li>" +
                            "<li>Nose</li>" +
                            "<li>Mouth</li>" +
                            "<li>Neck</li>" +
                            "<li>Chest</li>" +
                            "<li>Arm</li>" +
                            "<li>Hand</li>" +
                            "<li>Leg</li>" +
                            "<li>Foot</li>" +
                            "</ul>",

                    "<h2>Body Shape</h2>" +
                            "<p><b>Round</b></p>" +
                            "<p><b>Diamond Shape</b></p>" +
                            "<p><b>Triangle</b></p>" +
                            "<p><b>Hourglass</b></p>" +
                            "<p><b>Rectangle</b></p>" +
                            "<p><b>Pear</b></p>" +
                            "<p><b>Inverted Triangle</b></p>" +
                            "<p><b>Trapezoid</b></p>",

                    "<h2>Actions of the Body Parts</h2>" +
                            "<p><b>Weight-bearing</b></p>" +
                            "<p><b>Receive force</b></p>" +
                            "<p><b>Apply force</b></p>" +
                            "<p><b>Lead the Action</b></p>" +
                            "<p><b>Weight Transfer</b></p>",

                    "<h2>Actions of the Whole Body</h2>" +
                            "<p><b>Locomotor skills</b></p>" +
                            "<p><b>Non-locomotor skills</b></p>" +
                            "<p><b>Manipulative skills</b></p>",

                    "<h2>Space</h2>" +
                            "<p>They need a place to move. Space is an important concept in movement education. Teaching students about space in terms of movement education involves teaching directions, such as up and down and left and right. However, space is usually taught to be based on three different planes.</p>" +
                            "<p>The sagittal plane- is the imaginary plane that divides the body into the left and right sides.</p>" +
                            "<p>The frontal plane- divides the body into front and back planes, like the front and back of a sandwich.</p>" +
                            "<p>The traverse plane involves twisting movements, such as doing a log roll with your body.</p>",

                    "<h2>Effort</h2>" +
                            "<p>They require the energy to move. Effort is the main factor of movement. Flow and time are both parts of the effort.</p>" +
                            "<p><b>Time:</b> How Quickly or Slowly a Movement is performed.</p>" +
                            "<p><b>Flow:</b> How Smooth or Choppy movement is Performed.</p>" +
                            "<p>Effort is the all-encompassing factor. The effort combines: Quality, Shade, Passions, and Inner Attitudes.</p>",

                    "<h2>Relationship</h2>" +
                            "<p>They move about others. This allows them to explore things by themselves, doing those different actions with local motor skills, non-loco-motor or manipulative skills in partner pairs or groups, and they can explore doing them as a matching pair or group, mirroring where they're kind of doing the same thing on the same side of the body as they face each other, leading or following one another.</p>"
            }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson_detail, container, false);

        lessonDetailTitle = view.findViewById(R.id.lesson_detail_title);
        lessonContent = view.findViewById(R.id.lesson_content);
        pageNumber = view.findViewById(R.id.page_number);
        prevButton = view.findViewById(R.id.prev_button);
        nextButton = view.findViewById(R.id.next_button);
        finishButton = view.findViewById(R.id.finish_button);

        Bundle args = getArguments();
        if (args != null) {
            currentLesson = args.getInt("lesson_number", 1) - 1; // Convert to zero-based index
            currentPage = args.getInt("start_page", 1); // Default to page 1 if not specified
        }

        Log.d("LessonDetailFragment", "Current Lesson: " + currentLesson);
        Log.d("LessonDetailFragment", "Current Page: " + currentPage);

        updatePage();

        prevButton.setOnClickListener(v -> {
            if (currentPage > 1) {
                currentPage--;
                updatePage();
            }
        });

        nextButton.setOnClickListener(v -> {
            if (currentPage < totalPagesPerLesson) {
                currentPage++;
                updatePage();
            } else {
                finishLesson();
            }
        });

        finishButton.setOnClickListener(v -> finishLesson());

        return view;
    }

    private void updatePage() {
        lessonDetailTitle.setText(lessonTitles[currentLesson]);
        pageNumber.setText(currentPage + "/" + totalPagesPerLesson);

        if (currentLesson < lessonContents.length && currentPage <= lessonContents[currentLesson].length) {
            String htmlContent = lessonContents[currentLesson][currentPage - 1];
            lessonContent.setText(Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_LEGACY, source -> {
                Drawable drawable;
                int resId = getResources().getIdentifier(source, "drawable", getActivity().getPackageName());
                drawable = getResources().getDrawable(resId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            }, null));
        } else {
            lessonContent.setText(Html.fromHtml("<h2>Content not available</h2>"));
        }

        prevButton.setVisibility((currentPage == 1) ? View.GONE : View.VISIBLE);

        if (currentPage == totalPagesPerLesson) {
            nextButton.setVisibility(View.GONE);
            finishButton.setVisibility(View.VISIBLE);
        } else {
            nextButton.setVisibility(View.VISIBLE);
            finishButton.setVisibility(View.GONE);
        }
    }

    private void finishLesson() {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_lessonDetailFragment_to_quizConfirmationFragment);
    }
}
