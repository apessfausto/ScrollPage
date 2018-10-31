package br.com.apess.scrollpage

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Notificação
         */



        /**
         * Montando a lista para preencher os dados do aplicativo, no futuro será usado query do banco para popular
         */

        var estilos = arrayOf("Weizenbier","Brown Porter", "Irish Red Ale" )

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, estilos)

        //adicionando o modelo com a lista de opções no spinner
        sEstilos.adapter = adapter

        sEstilos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

                //pegando o valor selecionado no spinner
                val selectedItem = parent?.getItemAtPosition(position).toString()

                //cada posição tem uma imagem e um texto
                when(position){
                    0 -> {
                        txtEstilo.text = (selectedItem + "Aroma: Moderate to strong phenols (usually clove) and fruity esters (usually banana). The balance and intensity of the phenol and ester components can vary but the best examples are reasonably balanced and fairly prominent. Noble hop character ranges from low to none. A light to moderate wheat aroma (which might be perceived as bready or grainy) may be present but other malt characteristics should not. No diacetyl or DMS. Optional, but acceptable, aromatics can include a light, citrusy tartness, a light to moderate vanilla character, and/or a low bubblegum aroma. None of these optional characteristics should be high or dominant, but often can add to the complexity and balance.\n" +
                                "\n" +
                                "Appearance: Pale straw to very dark gold in color. A very thick, moussy, long-lasting white head is characteristic. The high protein content of wheat impairs clarity in an unfiltered beer, although the level of haze is somewhat variable. A beer “mit hefe” is also cloudy from suspended yeast sediment (which should be roused before drinking). The filtered Krystal version has no yeast and is brilliantly clear.\n" +
                                "\n" +
                                "Flavor: Low to moderately strong banana and clove flavor. The balance and intensity of the phenol and ester components can vary but the best examples are reasonably balanced and fairly prominent. Optionally, a very light to moderate vanilla character and/or low bubblegum notes can accentuate the banana flavor, sweetness and roundness; neither should be dominant if present. The soft, somewhat bready or grainy flavor of wheat is complementary, as is a slightly sweet Pils malt character. Hop flavor is very low to none, and hop bitterness is very low to moderately low. A tart, citrusy character from yeast and high carbonation is often present. Well rounded, flavorful palate with a relatively dry finish. No diacetyl or DMS.\n" +
                                "\n" +
                                "Mouthfeel: Medium-light to medium body; never heavy. Suspended yeast may increase the perception of body. The texture of wheat imparts the sensation of a fluffy, creamy fullness that may progress to a light, spritzy finish aided by high carbonation. Always effervescent.\n" +
                                "\n" +
                                "Overall Impression: A pale, spicy, fruity, refreshing wheat-based ale.\n" +
                                "\n" +
                                "Comments: These are refreshing, fast-maturing beers that are lightly hopped and show a unique banana-and-clove yeast character. These beers often don’t age well and are best enjoyed while young and fresh. The version “mit hefe” is served with yeast sediment stirred in; the krystal version is filtered for excellent clarity. Bottles with yeast are traditionally swirled or gently rolled prior to serving. The character of a krystal weizen is generally fruitier and less phenolic than that of the hefe-weizen.\n" +
                                "\n" +
                                "History: A traditional wheat-based ale originating in Southern Germany that is a specialty for summer consumption, but generally produced year-round.\n" +
                                "\n" +
                                "Ingredients: By German law, at least 50% of the grist must be malted wheat, although some versions use up to 70%; the remainder is Pilsner malt. A traditional decoction mash gives the appropriate body without cloying sweetness. Weizen ale yeasts produce the typical spicy and fruity character, although extreme fermentation temperatures can affect the balance and produce off-flavors. A small amount of noble hops are used only for bitterness.\n" +
                                "\n" +
                                "Vital Statistics:\tOG: 1.044 – 1.052\n" +
                                "IBUs: 8 – 15\tFG: 1.010 – 1.014\n" +
                                "SRM: 2 – 8\tABV: 4.3 – 5.6%\n" +
                                "Commercial Examples: Weihenstephaner Hefeweissbier, Schneider Weisse Weizenhell, Paulaner Hefe-Weizen, Hacker-Pschorr Weisse, Plank Bavarian Hefeweizen, Ayinger Bräu Weisse, Ettaler Weissbier Hell, Franziskaner Hefe-Weisse, Andechser Weissbier Hefetrüb, Kapuziner Weissbier, Erdinger Weissbier, Penn Weizen, Barrelhouse Hocking Hills HefeWeizen, Eisenbahn Weizenbier")

                        imgEstilo.visibility = View.VISIBLE
                        imgEstilo.setImageResource(R.drawable.weiss)
                        notification()
                    }

                    1 -> { txtEstilo.text = (selectedItem + "\n" +
                            "Aroma: Malt aroma with mild roastiness should be evident, and may have a chocolaty quality. May also show some non-roasted malt character in support (caramelly, grainy, bready, nutty, toffee-like and/or sweet). English hop aroma moderate to none. Fruity esters moderate to none. Diacetyl low to none.\n" +
                            "\n" +
                            "Appearance: Light brown to dark brown in color, often with ruby highlights when held up to light. Good clarity, although may approach being opaque. Moderate off-white to light tan head with good to fair retention.\n" +
                            "\n" +
                            "Flavor: Malt flavor includes a mild to moderate roastiness (frequently with a chocolate character) and often a significant caramel, nutty, and/or toffee character. May have other secondary flavors such as coffee, licorice, biscuits or toast in support. Should not have a significant black malt character (acrid, burnt, or harsh roasted flavors), although small amounts may contribute a bitter chocolate complexity. English hop flavor moderate to none. Medium-low to medium hop bitterness will vary the balance from slightly malty to slightly bitter. Usually fairly well attenuated, although somewhat sweet versions exist. Diacetyl should be moderately low to none. Moderate to low fruity esters.\n" +
                            "\n" +
                            "Mouthfeel: Medium-light to medium body. Moderately low to moderately high carbonation.\n" +
                            "\n" +
                            "Overall Impression: A fairly substantial English dark ale with restrained roasty characteristics.\n" +
                            "\n" +
                            "Comments: Differs from a robust porter in that it usually has softer, sweeter and more caramelly flavors, lower gravities, and usually less alcohol. More substance and roast than a brown ale. Higher in gravity than a dark mild. Some versions are fermented with lager yeast. Balance tends toward malt more than hops. Usually has an “English” character. Historical versions with Brettanomyces, sourness, or smokiness should be entered in the Specialty Beer category (23).\n" +
                            "\n" +
                            "History: Originating in England, porter evolved from a blend of beers or gyles known as “Entire.” A precursor to stout. Said to have been favored by porters and other physical laborers.\n" +
                            "\n" +
                            "Ingredients: English ingredients are most common. May contain several malts, including chocolate and/or other dark roasted malts and caramel-type malts. Historical versions would use a significant amount of brown malt. Usually does not contain large amounts of black patent malt or roasted barley. English hops are most common, but are usually subdued. London or Dublin-type water (moderate carbonate hardness) is traditional. English or Irish ale yeast, or occasionally lager yeast, is used. May contain a moderate amount of adjuncts (sugars, maize, molasses, treacle, etc.).\n" +
                            "\n" +
                            "Vital Statistics:\tOG: 1.040 – 1.052\n" +
                            "IBUs: 18 – 35\tFG: 1.008 – 1.014\n" +
                            "SRM: 20 – 30\tABV: 4 – 5.4%\n" +
                            "Commercial Examples: Fuller's London Porter, Samuel Smith Taddy Porter, Burton Bridge Burton Porter, RCH Old Slug Porter, Nethergate Old Growler Porter, Hambleton Nightmare Porter, Harvey’s Tom Paine Original Old Porter, Salopian Entire Butt English Porter, St. Peters Old-Style Porter, Shepherd Neame Original Porter, Flag Porter, Wasatch Polygamy Porter")
                        imgEstilo.visibility = View.VISIBLE
                        imgEstilo.setImageResource(R.drawable.porter)
                        notification()

                    }

                    2 -> { txtEstilo.text = (selectedItem + "Aroma: Low to moderate malt aroma, generally caramel-like but occasionally toasty or toffee-like in nature. May have a light buttery character (although this is not required). Hop aroma is low to none (usually not present). Quite clean.\n" +
                            "\n" +
                            "Appearance: Amber to deep reddish copper color (most examples have a deep reddish hue). Clear. Low off-white to tan colored head.\n" +
                            "\n" +
                            "Flavor: Moderate caramel malt flavor and sweetness, occasionally with a buttered toast or toffee-like quality. Finishes with a light taste of roasted grain, which lends a characteristic dryness to the finish. Generally no flavor hops, although some examples may have a light English hop flavor. Medium-low hop bitterness, although light use of roasted grains may increase the perception of bitterness to the medium range. Medium-dry to dry finish. Clean and smooth (lager versions can be very smooth). No esters.\n" +
                            "\n" +
                            "Mouthfeel: Medium-light to medium body, although examples containing low levels of diacetyl may have a slightly slick mouthfeel. Moderate carbonation. Smooth. Moderately attenuated (more so than Scottish ales). May have a slight alcohol warmth in stronger versions.\n" +
                            "\n" +
                            "Overall Impression: An easy-drinking pint. Malt-focused with an initial sweetness and a roasted dryness in the finish.\n" +
                            "\n" +
                            "Comments: Sometimes brewed as a lager (if so, generally will not exhibit a diacetyl character). When served too cold, the roasted character and bitterness may seem more elevated.\n" +
                            "\n" +
                            "Ingredients: May contain some adjuncts (corn, rice, or sugar), although excessive adjunct use will harm the character of the beer. Generally has a bit of roasted barley to provide reddish color and dry roasted finish. UK/Irish malts, hops, yeast.\n" +
                            "\n" +
                            "Vital Statistics:\tOG: 1.044 – 1.060\n" +
                            "IBUs: 17 – 28\tFG: 1.010 – 1.014\n" +
                            "SRM: 9 – 18\tABV: 4.0 – 6.0%\n" +
                            "Commercial Examples: Three Floyds Brian Boru Old Irish Ale, Great Lakes Conway’s Irish Ale (a bit strong at 6.5%), Kilkenny Irish Beer, O’Hara’s Irish Red Ale, Smithwick’s Irish Ale, Beamish Red Ale, Caffrey’s Irish Ale, Goose Island Kilgubbin Red Ale, Murphy’s Irish Red (lager), Boulevard Irish Ale, Harpoon Hibernian Ale\n" +
                            "\n")
                        imgEstilo.visibility = View.VISIBLE
                        imgEstilo.setImageResource(R.drawable.redale)
                        notification()

                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                imgEstilo.visibility = View.GONE
                txtEstilo.text = ""
            }
        }

    }
    fun notification() {
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val mNotification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
        } else {
            Notification.Builder(this)
        }.apply {
            setContentIntent(pendingIntent)

            //icone na notificação
            setSmallIcon(R.drawable.notification_icon_background)

            setAutoCancel(true)

            //titulo notificação
            setContentTitle(sEstilos.selectedItem.toString())

            //mensagem notificação
            setContentText("MESSAGE")
        }.build()
        val mNotificationId: Int = 1000
        val nManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nManager.notify(mNotificationId, mNotification)


    }

    private val channelId = "fgoncalves.apess.com"


}