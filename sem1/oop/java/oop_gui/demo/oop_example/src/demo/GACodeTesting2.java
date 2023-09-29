package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author User
 */
public class GACodeTesting2 {

    /**
     * @param args the command line arguments
     */
    
    public void search() {
        hilit.removeAllHighlights();
        
        String s = entry.getText();
        if (s.length() <= 0) {
            message("Nothing to search");
            return;
        }
        
        String content = textArea.getText();
        int index = content.indexOf(s, 0);
        if (index >= 0) {   // match found
            try {
                int end = index + s.length();
                hilit.addHighlight(index, end, painter);
                textArea.setCaretPosition(end);
                entry.setBackground(entryBg);
                message("'" + s + "' found. Press ESC to end search");
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        } else {
            entry.setBackground(ERROR_COLOR);
            message("'" + s + "' not found. Press ESC to start a new search");
        }
    }
    
    public static void main(String[] args) {
        String sample_art = "It was March 2005 when the Oscar-winning movie star called me. He had read an article I had written - something about how the celebrity magazines make up lies - and had tracked down my number. He wanted to meet over lunch. He asked me if I could be trusted. The last thing he wanted to see in the papers, he said, was some story about my lunch with Russell Crowe. I told him not to worry. I wouldn't want to read that story either.\n" +
"\n" +
"The following day we met at a restaurant of his choosing, me in my best three-piece suit and hat, him in sweat suit and cap. He hoped I didn't mind, but he'd called ahead and ordered food for both of us. He was sure it would be to my liking.\n" +
"\n" +
"The next hour and a half was basically an interrogation as Russell Crowe, head down over his plate, hurled question after question from under the beak of his cap. Where did I grow up? What was my childhood like? What did my father do? I was so busy answering questions that I scarcely had a moment to taste the food.\n" +
"\n" +
"At last, Russell announced he had one more question, which I could choose not to answer if I so wished: he wanted to know how much I earned. And like a little boy asked his age by the king, I told him.\n" +
"\n" +
"Then he stood, shook my hand, thanked me for being so forthcoming and bade me farewell, adding that if I ever wanted to see his beloved South Sydney football team play, I need only call him and there'd be a seat for me in his private box.\n" +
"\n" +
"That night, in our rented home in Sydney's inner west, my wife Kellie and I discussed the meaning of it all. Could it be that Russell Crowe needed a writer? Or a friend? You don't ask a man's salary unless you plan to employ him, do you? As intriguing as it was, we decided to try to forget the whole business before it drove us crazy, to catalogue it as nothing more than an unscheduled encounter with global fame.\n" +
"\n" +
"A few nights later I received a call from a man with an American accent. His name was Keith. He was Russell Crowe's personal assistant and he wished to know whether I would be accepting Russell's invitation to the football. Rugby league is not my game but to stay home would be churlish; it would also constitute an abandonment of my naturally enquiring instinct.\n" +
"\n" +
"And so Kellie and I dressed up for a night on the town and went to the football, where we met Russell, his son, Charlie, Charlie's nannies and several of Russell's friends, all dressed down for a day at the football. Though Russell was charming and everyone friendly, my wife and I had felt so foolish - such dolled-up commoners in the rich man's shed - that upon returning home that night we agreed to play along with Russell Crowe no further. His world was no place for us.\n" +
"\n" +
"But the calls continued. Keith wanted my email address; another assistant phoned wanting to know my precise whereabouts, at that instant, as she had a book Russell had promised to give to me and her orders were to deliver it personally and immediately, which she did on a crowded Sydney street.\n" +
"\n" +
"It was now quite clear that, unless besieged by some bizarre infatuation, Russell had something in mind for me. Though I knew not what it could be, my imagination become industrious as I began to foresee a new life for me and mine - clothes for Kellie and a bounty of new toys for my little boy, all to be enjoyed in a house we actually owned. After all, next to the Prime Minister and the odd media magnate, there was nobody more powerful in Australia than Mr Russell Crowe, and any crumb that might spill from his table would tumble as a banquet to my world.\n" +
"\n" +
"Then, one evening, Keith called to ask if I had a moment for his boss. Russell came to the phone and for a few minutes we shot the breeze. Then he asked if I had some time later in the week, as he wished for me to come to his home and listen to some music.\n" +
"\n" +
"His music.\n" +
"\n" +
"My gut fell down an elevator shaft. Though completely unfamiliar with Crowe's music, I was familiar enough with the esteem in which it was held by those whose opinions seemed to matter. Was this what the last few weeks had been about?\n" +
"\n" +
"With foreboding I trudged up the Woolloomooloo pier a few nights later, rehearsing those valueless critics' platitudes that had extracted me from hot spots in my days as a music reviewer: \"Interesting\"; \"Not at all what I expected\"; \"'Amazing' is not the word.\"\n" +
"\n" +
"A security guard met me at the door and escorted me up the elevator, passing the baton to Keith as the doors opened on a dark, Romanesque foyer. Keith shook my hand and led me through a long hallway lined with classic guitars, then into Russell's den, a kind of captain's cabin affair with a view of the Sydney Harbour skyline. Motioning towards the couch, Keith told me that Russell was temporarily disposed elsewhere in the mansion-apartment and had suggested I begin listening to the CD in the meantime. As I made myself comfortable, Keith cranked the sound system and promptly left the room, closing the door behind him.\n" +
"\n" +
"It's fair to say Russell's music was a surprise. Where I had expected a lumpen, tuneless racket, what I heard instead was something far less remarkable - the colourless strums of a subway busker glazed with the deodorized slick of Christian rock. The most charitable thing I could feel about it was that it wasn't complete crap.\n" +
"\n" +
"I don't know what made me look towards the ceiling, but as I did I noticed what I thought was a camera. Pointed straight at me. To this day I do not know if it was a lens or simply a classy light fitting but, just to be sure, I proceeded to rock my head to the beat, for the benefit of anyone who may be watching from some control room vault.\n" +
"\n" +
"After 37 minutes the ten songs were over and, as the final strum went \"wang\", a door opened and Russell appeared, remarking on his own \"good timing\". A nervous silence ensued until he finally asked for my thoughts. I told him the music was \"interesting\" and \"not at all what I had expected\". He asked me to name my favourite of the tunes, and I lucky-dipped a title from the sleeve (unluckily, it turned out to be the one song Crowe himself hadn't written).\n" +
"\n" +
"He spoke for a time about the media and how many were quick to write him off as a musical nincompoop, when he suspected they hadn't heard so much as a tune. Russell Crowe the musician, he said, laboured under a dreadful PR problem. It was then that I asked - for I knew that I must - how I might be able to help.";
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JTextField searchField1 = new JTextField(20);
        panel1.add(searchField1, BorderLayout.NORTH);
        JButton searchButton1 = new JButton("Search");
        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField1.getText();
                // perform search for tab 1
            }
        });
        panel1.add(searchButton1, BorderLayout.SOUTH);
        JTextArea articleArea1 = new JTextArea();
        articleArea1.setEditable(false);
        articleArea1.append(sample_art);
        panel1.add(new JScrollPane(articleArea1), BorderLayout.CENTER);
        tabbedPane.addTab("Tab 1", panel1);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JTextField searchField2 = new JTextField(20);
        panel2.add(searchField2, BorderLayout.NORTH);
        JButton searchButton2 = new JButton("Search");
        searchButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField2.getText();
                // perform search for tab 2
            }
        });
        panel2.add(searchButton2, BorderLayout.SOUTH);
        JTextArea articleArea2 = new JTextArea();
        panel2.add(new JScrollPane(articleArea2), BorderLayout.CENTER);
        tabbedPane.addTab("Tab 2", panel2);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    
}