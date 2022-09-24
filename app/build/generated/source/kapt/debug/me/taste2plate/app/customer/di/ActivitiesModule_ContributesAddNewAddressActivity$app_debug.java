package me.taste2plate.app.customer.di;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import me.taste2plate.app.customer.ui.customer.AddNewAddressActivity;

@Module(
  subcomponents =
      ActivitiesModule_ContributesAddNewAddressActivity$app_debug.AddNewAddressActivitySubcomponent
          .class
)
public abstract class ActivitiesModule_ContributesAddNewAddressActivity$app_debug {
  private ActivitiesModule_ContributesAddNewAddressActivity$app_debug() {}

  @Binds
  @IntoMap
  @ClassKey(AddNewAddressActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AddNewAddressActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface AddNewAddressActivitySubcomponent
      extends AndroidInjector<AddNewAddressActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<AddNewAddressActivity> {}
  }
}
