// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.di;

import com.google.firebase.firestore.CollectionReference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FirebaseModule_ProvidesUsersFactory implements Factory<CollectionReference> {
  private final FirebaseModule module;

  public FirebaseModule_ProvidesUsersFactory(FirebaseModule module) {
    this.module = module;
  }

  @Override
  public CollectionReference get() {
    return providesUsers(module);
  }

  public static FirebaseModule_ProvidesUsersFactory create(FirebaseModule module) {
    return new FirebaseModule_ProvidesUsersFactory(module);
  }

  public static CollectionReference providesUsers(FirebaseModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesUsers());
  }
}
