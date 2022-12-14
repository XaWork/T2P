// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.viewmodels;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;
import me.taste2plate.app.customer.repo.CustomRepository;
import me.taste2plate.app.customer.repo.CustomerRepository;
import me.taste2plate.app.customer.repo.FirebaseUserRepository;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UserViewModel_Factory implements Factory<UserViewModel> {
  private final Provider<FirebaseUserRepository> firebaseUserRepositoryProvider;

  private final Provider<CustomerRepository> customerRepositoryProvider;

  private final Provider<CustomRepository> customRepositoryProvider;

  public UserViewModel_Factory(Provider<FirebaseUserRepository> firebaseUserRepositoryProvider,
      Provider<CustomerRepository> customerRepositoryProvider,
      Provider<CustomRepository> customRepositoryProvider) {
    this.firebaseUserRepositoryProvider = firebaseUserRepositoryProvider;
    this.customerRepositoryProvider = customerRepositoryProvider;
    this.customRepositoryProvider = customRepositoryProvider;
  }

  @Override
  public UserViewModel get() {
    return newInstance(firebaseUserRepositoryProvider.get(), customerRepositoryProvider.get(), customRepositoryProvider.get());
  }

  public static UserViewModel_Factory create(
      Provider<FirebaseUserRepository> firebaseUserRepositoryProvider,
      Provider<CustomerRepository> customerRepositoryProvider,
      Provider<CustomRepository> customRepositoryProvider) {
    return new UserViewModel_Factory(firebaseUserRepositoryProvider, customerRepositoryProvider, customRepositoryProvider);
  }

  public static UserViewModel newInstance(FirebaseUserRepository firebaseUserRepository,
      CustomerRepository customerRepository, CustomRepository customRepository) {
    return new UserViewModel(firebaseUserRepository, customerRepository, customRepository);
  }
}
