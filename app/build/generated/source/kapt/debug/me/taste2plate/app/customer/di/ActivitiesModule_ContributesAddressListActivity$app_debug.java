package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.AddressListActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesAddressListActivity$app_debug.AddressListActivitySubcomponent
          .class
)
public abstract class ActivitiesModule_ContributesAddressListActivity$app_debug {
  private ActivitiesModule_ContributesAddressListActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(AddressListActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddressListActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface AddressListActivitySubcomponent extends AndroidInjector<AddressListActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AddressListActivity> {}
  }
}
