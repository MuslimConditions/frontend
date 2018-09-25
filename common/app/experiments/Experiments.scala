package experiments

import conf.switches.{Owner, SwitchGroup}
import experiments.ParticipationGroups._
import org.joda.time.LocalDate
import play.api.mvc.RequestHeader

object ActiveExperiments extends ExperimentsDefinition {
  override val allExperiments: Set[Experiment] = Set(
    AudioPageChange,
    CommercialClientLogging,
    OrielParticipation,
    OldTLSSupportDeprecation,
    DotcomponentsRendering
  )
  implicit val canCheckExperiment = new CanCheckExperiment(this)
}

object CommercialClientLogging extends Experiment(
  name = "commercial-client-logging",
  description = "A slice of the audience who will post their commercial js performance data",
  owners = Owner.group(SwitchGroup.Commercial),
  sellByDate = new LocalDate(2018, 10, 17),
  participationGroup = Perc1A
)

object OrielParticipation extends Experiment(
  name = "oriel-participation",
  description = "A slice of the audience who will participate in Oriel ad-blocking technology",
  owners = Seq(Owner.withGithub("janua")),
  sellByDate = new LocalDate(2018, 10, 17),
  participationGroup = Perc20A
)

object OldTLSSupportDeprecation extends Experiment(
  name = "old-tls-support-deprecation",
  description = "This will turn on a deprecation notice to any user who is accessing our site using TLS v1.0 or v1.1",
  owners = Seq(Owner.withGithub("natalialkb")),
  sellByDate = new LocalDate(2019, 1,15),
  // Custom group based on header set in Fastly
  participationGroup = TLSSupport
)

object AudioPageChange extends Experiment(
  name = "audio-page-change",
  description = "Show a different version of the audio page to certain people",
  owners = Owner.group(SwitchGroup.Journalism),
  sellByDate = new LocalDate(2018, 9, 27),
  participationGroup = Perc5A
)

object DotcomponentsRendering extends Experiment(
  name = "dotcomponents-rendering",
  description = "This will allow rendering of articles to use dotcomponents, if that page is supported",
  owners = Seq(Owner.withGithub("MatthewJWalls")),
  sellByDate = new LocalDate(2018, 12, 31),
  participationGroup = Perc0A
)

object MegaMostViewed extends Experiment(
  name = "mega-most-viewed",
  description = "Displays an extended height most viewed to support larger MPU",
  owners = Seq(Owner.withGithub("nicl")),
  sellByDate = new LocalDate(2018, 12, 1),
  participationGroup = Perc0A
)
