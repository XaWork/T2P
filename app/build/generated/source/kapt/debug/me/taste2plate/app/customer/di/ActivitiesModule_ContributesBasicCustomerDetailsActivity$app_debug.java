package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.BasicCustomerDetailsActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesBasicCustomerDetailsActivity$app_debug
          .BasicCustomerDetailsActivitySubcomponent.class
)
public abstract class ActivitiesModule_ContributesBasicCustomerDetailsActivity$app_debug {
  private ActivitiesModule_ContributesBasicCustomerDetailsActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(BasicCustomerDetailsActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BasicCustomerDetailsActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface BasicCustomerDetailsActivitySubcomponent
      extends AndroidInjector<BasicCustomerDetailsActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BasicCustomerDetailsActivity> {}
  }
}
